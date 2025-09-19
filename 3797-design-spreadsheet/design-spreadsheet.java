//arinjayjha
import java.util.*;

class Spreadsheet {
    private Map<String, Integer> cells;

    public Spreadsheet(int height) {      // height is not used in this simple design
        cells = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.put(cell, 0);
    }

    public int getValue(String expr) {
        // If it's a formula beginning with '=' evaluate it
        if (expr.startsWith("=")) {
            String[] tokens = expr.substring(1).split("\\+");
            int sum = 0;
            for (String t : tokens) {
                t = t.trim();
                if (t.isEmpty()) continue;
                if (Character.isDigit(t.charAt(0))) {
                    sum += Integer.parseInt(t);
                } else {
                    sum += cells.getOrDefault(t, 0);
                }
            }
            return sum;
        } else {
            // Just a cell reference
            return cells.getOrDefault(expr, 0);
        }
    }
}
