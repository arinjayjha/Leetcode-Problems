//arinjayjha
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");
        for (String p : parts) {
            if (p.equals("") || p.equals(".")) continue;
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append("/").append(it.next());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
