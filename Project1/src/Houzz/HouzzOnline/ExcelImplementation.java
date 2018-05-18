import java.util.*;

/**
 * Created by norafang on 8/23/17.
 * Assume input will always be value as integer or expression as A=B+C
 * Set default value for the cell as 0
 * 没实现解除之前的依赖关系
 */
public class ExcelImplementation {
    HashMap<String, Cell> cells;
    public ExcelImplementation() {
        cells = new HashMap<>();
    }

    public int getCell(String label) {
        if (!cells.containsKey(label)) {
            cells.put(label, new Cell("", label));
            cells.get(label).val = 0;
        }
        return cells.get(label).val;
    }
    public void updateCell(String label, String expression) {
        if (!cells.containsKey(label)) {
            cells.put(label, new Cell(expression, label));
        } else {
            cells.get(label).expression = expression;
        }
        cells.get(label).val = getValue(expression);
        updateDepends(expression, label);
        updateDependents(cells.get(label).dependents, label);
    }
    private void updateDependents(List<String> dependents, String label) {
        HashMap<String, Integer> degree = new HashMap<>();
        HashSet<String> updateSet = new HashSet<>();
        // Initialize degree map, create graph
        for (String dependent: dependents) {
            degree.put(dependent, 1);
        }
        Queue<String> list = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (String dependent: dependents) {
            list.add(dependent);
        }
        while (!list.isEmpty()) {
            String dependent = list.poll();
            if (!visited.contains(dependent)) {
                for (String dependOnDependent : cells.get(dependent).dependents) {
                    if (degree.containsKey(dependOnDependent)) {
                        int current = degree.get(dependOnDependent);
                        degree.put(dependOnDependent, current + 1);
                    } else {
                        degree.put(dependOnDependent, 1);
                    }
                    if (!dependents.contains(dependOnDependent) && !visited.contains(dependOnDependent)) {
                        list.offer(dependOnDependent);
                    }
                }
            }
            visited.add(dependent);
        }
        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(label);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String depend : cells.get(current).dependents) {
                if (degree.containsKey(depend)) {
                    int count = degree.get(depend);
                    degree.put(depend, count - 1);
                    if (count - 1 == 0) {
                        queue.offer(depend);
                        Cell cell = cells.get(depend);
                        cell.val = getValue(cell.expression);
                    }
                }
            }
        }
    }
    private void updateDepends(String expression, String label) {
        if (expression.equals("") || !expression.contains("=")) {
            return;
        }
        int equal = expression.indexOf("=");
        int plus = expression.indexOf("+");
        String component1 = expression.substring(equal + 1, plus);
        String component2 = expression.substring(plus + 1);
        if (isLabel(component1)) {
            if (!cells.containsKey(label)) {
                cells.put(label, new Cell("", label));
                cells.get(label).val = 0;
            }
            cells.get(component1).dependents.add(label);
        }
        if (isLabel(component2)) {
            if (!cells.containsKey(label)) {
                cells.put(label, new Cell("", label));
                cells.get(label).val = 0;
            }
            cells.get(component2).dependents.add(label);
        }

    }
    private int getValue(String expression) {
        if (expression.equals("")) {
            return 0;
        }
        if (!expression.contains("=")) {
            return Integer.parseInt(expression);
        }
        int equal = expression.indexOf("=");
        int plus = expression.indexOf("+");
        String component1 = expression.substring(equal + 1, plus);
        String component2 = expression.substring(plus + 1);
        int comp1;
        int comp2;
        if (isLabel(component1)) {
            comp1 = getCell(component1);
        } else {
            comp1 = Integer.parseInt(component1);
        }
        if (isLabel(component2)) {
            comp2 = getCell(component2);
        } else {
            comp2 = Integer.parseInt(component2);
        }
        return comp1 + comp2;
    }
    private boolean isLabel(String s) {
        if (s.charAt(0) <= 'Z' && s.charAt(0) >= 'A') {
            return true;
        }
        return false;
    }
    class Cell {
        String label;
        int val;
        List<String> dependents;
        String expression;
        public Cell (String expression, String label){
            this.expression = expression;
            this.label = label;
            this.dependents = new ArrayList<>();
        }
    }
    public static void main (String[] args) {
        ExcelImplementation test = new ExcelImplementation();
        System.out.println("get() A1");
        System.out.println(test.getCell("A1"));
        System.out.println("update() A2=A1+A3");
        test.updateCell("A2", "A2=A1+A3");
        System.out.println("get() A2");
        System.out.println(test.getCell("A2"));
        System.out.println("update() A3=5");
        test.updateCell("A3", "5");
        System.out.println("get() A2");
        System.out.println(test.getCell("A2"));
        System.out.println("update() A1=A4+A3");
        test.updateCell("A1", "A1=A4+A3");
        System.out.println("get() A2");
        System.out.println(test.getCell("A2"));
        System.out.println("update() A4=A5+1");
        test.updateCell("A4", "A4=A5+1");
        System.out.println("get() A2");
        System.out.println(test.getCell("A2"));
        System.out.println("update() A5=1");
        test.updateCell("A5", "1");
        System.out.println("get() A2");
        System.out.println(test.getCell("A2"));
    }
}
