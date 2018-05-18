package edu.nyu.cs9053.homework11.network;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.*;


/**
 * User: blangel
 * <p>
 * A NIO implementation of a NetworkGameProvider.
 * <p>
 * The server takes the following commands:
 * <pre>
 *     foes Difficulty
 * </pre>
 * <pre>
 *     move
 * </pre>
 * where the String "foes Easy" would be a call to {@linkplain NetworkGameProvider#getRandomNumberOfNextFoes(String)}
 * with "Easy"
 * and a call using String "move" would be a call to {@linkplain NetworkGameProvider#getRandomNextMove()}
 */
public class GameServer implements NetworkGameProvider, Runnable {

    public static final String SERVER_HOST = "localhost";

    public static final int SERVER_PORT = 8080;

    private static final int READ_BUFFER_SIZE = 1024;

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private final ServerSocketChannel channel;

    private final Selector selector;

    private final ByteBuffer readBuffer;

    private final Map<SocketChannel, ByteBuffer> writeBuffers;

    private final Random random;

    public GameServer() throws IOException {
        channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(new java.net.InetSocketAddress(SERVER_HOST, SERVER_PORT));
        selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        readBuffer = ByteBuffer.allocate(READ_BUFFER_SIZE);
        this.writeBuffers = new HashMap<>();
        random = new Random();
        System.out.println("Server started on port >> " + SERVER_PORT);
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.run();
    }

    @Override
    public String getRandomNumberOfNextFoes(String difficulty) {
        int result;
        switch (difficulty) {
            case "Easy":
                result = random.nextInt(2);
                break;
            case "Medium":
                result = random.nextInt(3);
                break;
            case "Hard":
                result = random.nextInt(4);
                break;
            default:
                result = random.nextInt(2);
        }
        return Integer.toString(result);
    }

    @Override
    public String getRandomNextMove() {
        int randomDirection = random.nextInt(2);
        switch (randomDirection) {
            case 0:
                int verticalChance = random.nextInt(2);
                switch (verticalChance) {
                    case 0:
                        return "UP";
                    case 1:
                        return "DOWN";
                }
                break;
            case 1:
                int horizontalChance = random.nextInt(20);
                switch (horizontalChance) {
                    case 0:
                        return "RIGHT";
                    default:
                        return "LEFT";
                }
        }
        return null;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                process();
            } catch (IOException ioe) {
                System.out.printf("Exception - %s%n", ioe.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private void process() throws IOException {

        int events = selector.select();
        if (events < 1) {
            return;
        }

        Set<SelectionKey> keys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = keys.iterator();
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            String response = "";
            try {
                if (key.isAcceptable()) {
                    SocketChannel client = channel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    writeBuffers.put(client, ByteBuffer.allocate(READ_BUFFER_SIZE));
                }

                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    readBuffer.clear();

                    int result = client.read(readBuffer);

                    if (result == -1) {
                        writeBuffers.remove(client);

                        key.cancel();
                        continue;
                    }

                    for (Map.Entry<SocketChannel, ByteBuffer> entry : writeBuffers.entrySet()) {
                        SocketChannel otherClient = entry.getKey();
                        if (client != otherClient) {
                            ByteBuffer writeBuffer = entry.getValue();
                            readBuffer.flip();
                            writeBuffer.put(String.format("[%s] ", client.getRemoteAddress().toString()).getBytes());
                            writeBuffer.put(readBuffer);
                            writeBuffer.put((byte) '\n');
                        }
                    }
                    readBuffer.flip();
                    CharsetDecoder decoder = UTF8.newDecoder();
                    CharBuffer charBuffer = decoder.decode(readBuffer);

                    String command = charBuffer.toString();
                    if (command.startsWith("foes")) {
                        response = getRandomNumberOfNextFoes(command.split(" ")[1]);
                        System.out.printf("[%s] %s%n", client.getRemoteAddress().toString(), command);
                    } else if (command.equals("move")) {
                        response = getRandomNextMove();
                        System.out.printf("[%s] %s%n", client.getRemoteAddress().toString(), "move -> " + response);
                    }
                }
                if (key.isWritable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    client.write(ByteBuffer.wrap(response.getBytes()));
                }

            } finally {
                iterator.remove();
            }

        }
    }
}