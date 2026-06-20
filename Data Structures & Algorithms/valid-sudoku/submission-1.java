class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        List<HashSet<Character>> rows = new ArrayList<>(9);
        List<HashSet<Character>> cols = new ArrayList<>(9);
        List<HashSet<Character>> boxes = new ArrayList<>(9);

        // HashSet<Character>[] rows =  HashSet<Character>[9];
        // HashSet<Character>[] cols =  HashSet<Character>[9];
        // HashSet<Character>[] boxes = HashSet<Character>[9];

        for(int i = 0; i < 9; i++){
            rows.add(new HashSet<Character>(9));
            cols.add(new HashSet<Character>(9));
            boxes.add(new HashSet<Character>(9));
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i][j];

                // base condition to skip over empty cells
                if(c == '.'){
                    continue;
                }

                // checking in the row HashSet;
                if(rows.get(i).contains(c)){
                    return false;
                }else{
                    rows.get(i).add(c);
                }

                // checking in the column HashSet;
                if(cols.get(j).contains(c)){
                    return false;
                }else{
                    cols.get(j).add(c);
                }

                // checking in the box HashSet;
                if(boxes.get((i/3) * 3 + j/3).contains(c)){
                    return false;
                }else{
                    boxes.get((i/3) * 3 + j/3).add(c);
                }
            }
        }

        return true;
    }
}
