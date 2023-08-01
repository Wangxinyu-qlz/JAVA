import java.util.Scanner;

public class Biarray 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // int[][] a = new int[3][5];
        // // Initialize
        // int[][] b = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        // };
        
        final int SIZE = 3;
        int[][] board = new int[SIZE][SIZE];
        boolean gotResult = false;
        int numOfX = 0;
        int numOfO = 0;

        // 读入矩阵
        for ( int i=0; i<board.length; i++ )//行
        {
            for ( int j=0; j<board[i].length; j++ )//列
            {
                board[i][j] = in.nextInt();
            }
        }

        // 检查行
        if ( !gotResult )
        {
            for (int i=0; i<SIZE; i++)
            {
                numOfO = 0;
                numOfX = 0;
                for ( int j=0; j<SIZE; j++ )
                {
                    if( board[i][j] == 1 )
                    {
                        numOfX++;
                    }
                    else
                    {
                        numOfO++;
                    }
                }
                if ( numOfO==SIZE || numOfX==SIZE )
                {
                    gotResult = true;
                    break;
                }
            }
        }
        // 检查列
        if ( !gotResult )
        {
            for (int j=0; j<SIZE; j++)
            {
                numOfO = 0;
                numOfX = 0;
                for ( int i=0; i<SIZE; i++ )
                {
                    if( board[i][j] == 1 )
                    {
                        numOfX++;
                    }
                    else
                    {
                        numOfO++;
                    }
                }
                if ( numOfO==SIZE || numOfX==SIZE )
                {
                    gotResult = true;
                    break;
                }
            }
        }
        // 检查对角线
        if ( !gotResult )
        {
            numOfO = 0;
            numOfX = 0;
            for ( int i=0; i<SIZE; i++ )
            {
                if ( board[i][i] == 1 )
                {
                    numOfX++;
                }
                else
                {
                    numOfO++;
                }
            }
            if ( numOfO==SIZE || numOfX==SIZE )
            {
                gotResult = true;
            }
        }
        // 检查反对角线
        if ( !gotResult )
        {
            numOfO = 0;
            numOfX = 0;
            for ( int i=0; i<SIZE; i++ )
            {
                if ( board[i][SIZE-i-1] == 1 )
                {
                    numOfX++;
                }
                else
                {
                    numOfO++;
                }
            }
            if ( numOfO==SIZE || numOfX==SIZE )
            {
                gotResult = true;
            }
        }

        if ( gotResult )
        {
            if ( numOfX ==SIZE )
            {
                System.out.println("1赢了！");
            }
            else
            {
                System.out.println("0赢了！");
            }
        }
        else
        {
            System.out.println("胜负未分！");
        }

    }
}
