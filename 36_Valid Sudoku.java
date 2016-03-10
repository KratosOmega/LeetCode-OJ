public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length > 9 || board[0].length > 9 || board == null) {
            return false;
        }

        boolean[] brain;
        for (int x = 0; x < board.length; x++) {
            // Reset brain
            brain = new boolean[9];
            for (int y = 0; y < board[x].length; y++) {

                // ------- (1) Begin -------
                if (board[x][y] == '.') {
                    continue;
                }
                if (brain[board[x][y] - '1']) {
                    return false;
                } else {
                    brain[board[x][y] - '1'] = true;
                }
                // ------- (1) End -------

                // statments (1) above is the correct one, I used to use code below:
                /*
                // ------- (2) Begin -------
                if (board[x][y] != '.') {
                    if (brain[board[x][y] - '1']) {
                        return false;
                    } else {
                        brain[board[x][y] - '1'] = true;
                    }
                }
                // ------- (2) Begin -------
                */
                // which failed for not filter out '.' properly
                // so I changed to filter '.' out by using continue;
            }
        }

        for (int x = 0; x < board.length; x++) {
            // Reset brain
            brain = new boolean[9];
            for (int y = 0; y < board[x].length; y++) {
                if (board[y][x] == '.') {
                    continue;
                }
                if (brain[board[y][x] - '1']) {
                    return false;
                } else {
                    brain[board[y][x] - '1'] = true;
                }
            }
        }

        for (int block = 0; block < 9; block++) {
            // Reset brain
            brain = new boolean[9];
            for (int r = block / 3 * 3; r < block / 3 * 3 + 3; r++) {
                for (int c = block % 3 * 3; c < block % 3 * 3 + 3; c++) {
                    if (board[r][c] == '.') {
                        continue;
                    }
                    if (brain[board[r][c] - '1']) {
                        return false;
                    } else {
                        brain[board[r][c] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}


// 我是检票员，车上有10个人，途中休息时，来来回回上下车。假设我的记忆在时间内是有效地，
// 当我看到同一个人的时候，我意识到，他是否是之前就已经在车上的人，
// 又或者是新的人（逃票的）
// 问： 我的思维是通过扫描记忆，Verify出来的，还是直接计算出来的？ P=?=NP
// 当数据极大的时候，我的反应就会变慢，是否是证明了，我其实是采用Verify的方式，即猜测法？
// 但，假设给我足够长的时间，让我充分记忆，即使数据很大，我的scan也会随着记忆时间的增长，而变快
// 是否证明我的计数方法，并非是Verify （猜测）， 而是有着某种直接找到，或者知道是我记忆中的哪个data
// 从而快速加快了运算时间？

// C 只需一次数据曝光，就可记录数据
// H 通常需要多次曝光，而且需要持续曝光以保证数据的稳定性

// 但是，
// 当C 进行提取数据的时候，C通常需要scan所以数据，遵循一定算法，才能锁定目标数据 ==> 优点：准确， 缺点: 根据情况会有很慢的反应
// 当H 进行提取数据的时候，H通常不需要scan (又或者是脑部无意识进行了scan?) ==》 优点: 保证数据曝光强度的情况下，比C速度快, 缺点: 有可能不稳定。

// 分析：
// H在进行数据存储时，会提取数据特征，从而分类。 提取数据时，再次进行提取数据特征，根据特征，到指定的类别里面提取，从而加快速度。
// 数据曝光时间越长，所获取的数据特征越多，稳定性越好


// 猜想：
// 每当 读取一个data的时候，设定特征识别包来定义其独特的特征，当。。。

// 0 ~ 9, I know these 10 digits, 
// but I don't know if a random given digit exists in the pool unless I fileter each of the pool to verify its exsitence.
// Unless, I had been explosed in the pool for enough time to memoried the pool


// Given digit pool which can be 0 ~ 9 without duplication, and ask, if number "5" is in it?
// C: will do a scan untill 5 is found or not
// H: for enought time of pool's data explosion, H will just tell you wheter 5 is found or not.










