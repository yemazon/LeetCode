package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;
import edu.nyu.cs9053.homework11.game.GameProvider;
import edu.nyu.cs9053.homework11.game.screen.InputMove;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * User: blangel
 * <p>
 * A blocking IO implementation of a client which requests moves from a remote server implementing the
 * {@linkplain edu.nyu.cs9053.homework11.network.NetworkGameProvider}
 */
public class GameClient implements GameProvider {

    public static GameClient construct(Difficulty difficulty) {
        try {
            Socket socket = new Socket(GameServer.SERVER_HOST, GameServer.SERVER_PORT);
            socket.setKeepAlive(true);
            return new GameClient(difficulty, socket.getInputStream(), socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Difficulty difficulty;
    private final InputStream input;
    private final OutputStream output;

    public GameClient(Difficulty difficulty, InputStream input, OutputStream output) {
        this.difficulty = difficulty;
        this.input = input;
        this.output = output;
    }

    @Override
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public int getRandomNumberOfNextFoes() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("foes ").append(getDifficulty());
        try {
            sendToServer(stringBuilder.toString());
            return Integer.valueOf(readFromServer());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public InputMove getRandomNextMove() {
        try {
            sendToServer("move");
            switch (readFromServer()) {
                case "UP":
                    return InputMove.Up;
                case "DOWN":
                    return InputMove.Down;
                case "LEFT":
                    return InputMove.Left;
                case "RIGHT":
                    return InputMove.Right;
                default:
                    return null;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void sendToServer(String value) throws IOException {
        output.write(value.getBytes());
        output.flush();
    }

    private String readFromServer() throws IOException {
        int availableAmount = 0;
        while (availableAmount == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            availableAmount = input.available();
        }
        byte[] into = new byte[availableAmount];
        int read = input.read(into);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < read; i++) {
            stringBuilder.append((char) into[i]);
        }
        return stringBuilder.toString();
    }
}
