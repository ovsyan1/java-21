package threads.simpleApi.executorService;

import java.util.ArrayList;
import java.util.List;

class Helper {
    static List<List<String>> splitList(List<String> list, int countOfThreads) {
        int totalSize = list.size();
        int chunkSize = (int) Math.ceil((double) totalSize / countOfThreads);
        List<List<String>> lists = new ArrayList<>();

        for (int start = 0; start < totalSize; start += chunkSize) {
            int end = Math.min(start + chunkSize, totalSize);
            lists.add(list.subList(start, end));
        }

        return lists;
    }
}
