public class Main {
    public static void main(String[] args) {
        int errorCount = 0;
        int infoCount = 0;
        int warnCount = 0;
        int memoryCount = 0;
        int errorLogCounter = 100;
        Steque<String> errorLogEntries = new Steque<>();

        Steque<String> queue = new Steque<>();
        @SuppressWarnings("unused") String firstLine = StdIn.readLine(); //This gave me a severe headache until I realized that I am foolish and the data starts with "Log Entry"
        while (!StdIn.isEmpty()) {
            String item = StdIn.readLine();
            String[] fields = item.split(" ");
            String entryType = fields[2];
            String message = fields[3];

            queue.enqueue(item);
            switch (entryType) {
                case "ERROR" -> {
                    errorLogEntries.push(item);
                    errorCount++;
                }
                case "INFO" -> infoCount++;
                case "WARN" -> {
                    warnCount++;
                    if (message.equalsIgnoreCase("Memory")) {
                        memoryCount++;
                    }
                }
            }
            queue.pop();
        }
        errorLogEntries.printList(errorLogCounter);
        ConsoleColors.println("Total ERROR entries: " + errorCount, "violet");
        ConsoleColors.println("Total INFO entries: " + infoCount, "cyan");
        ConsoleColors.println("Total WARN entries: " + warnCount, "yellow");
        ConsoleColors.println("Total Memory warnings: " + memoryCount, "orange");
    }
}
