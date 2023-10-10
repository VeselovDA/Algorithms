package org.example.interview;

import java.util.Arrays;

/*
    Необходимо найти все острова на карте. В качестве карты предоставляется массив,
где ИСТИНА это суша, ЛОЖЬ это океан. Если суша ячейка полностью окружена водой или границами,
то она считается отдельным островом. Если 2 или больше ячеек подряд - считается как один остров.
Функция должна вернуть количество островов на карте.
*/
public class IslandFinder {

    public static int getIslandCounter(boolean[][] source) {
        int countIsland = 0;
        var copyMap = Arrays.copyOf(source, source.length);
        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[i].length; j++) {
                if (copyMap[i][j] == true) {
                    countIsland++;
                    sinkIsland(i, j, copyMap);
                }
            }
        }
        return countIsland;
    }

    private static void sinkIsland(int i, int j, boolean[][] copyMap) {
        if (i < 0 || i >= copyMap.length || j < 0 || j >= copyMap[i].length || copyMap[i][j] == false) {
            return;
        }
        copyMap[i][j] = false;
        sinkIsland(i, j + 1, copyMap);
        sinkIsland(i, j - 1, copyMap);
        sinkIsland(i + 1, j, copyMap);
        sinkIsland(i - 1, j, copyMap);
    }
}
