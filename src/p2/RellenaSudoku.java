/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

public class RellenaSudoku{

    public int[][] matriz = new int[9][9];

    public int[][] cargar_juego() {
        //matriz[1][2] = 3;//para pruebas
        matriz[0][2] = 9;
        matriz[0][0] = 1;
        matriz[0][5] = 8;
        matriz[0][6] = 5;
        matriz[0][7] = 4;
        matriz[1][8] = 7;
        matriz[2][1] = 5;
        matriz[2][2] = 4;
        matriz[2][4] = 9;
        matriz[2][6] = 1;
        matriz[3][3] = 4;
        matriz[3][5] = 6;
        matriz[3][6] = 3;
        matriz[3][7] = 2;
        matriz[4][1] = 8;
        matriz[4][2] = 2;
        matriz[4][6] = 4;
        matriz[4][7] = 1;
        matriz[5][1] = 3;
        matriz[5][2] = 5;
        matriz[5][3] = 2;
        matriz[5][5] = 1;
        matriz[6][2] = 7;
        matriz[6][4] = 3;
        matriz[6][6] = 2;
        matriz[6][7] = 5;
        matriz[7][0] = 9;
        matriz[7][4] = 1;
        matriz[8][1] = 4;
        matriz[8][2] = 3;
        matriz[8][3] = 8;
        matriz[8][7] = 9;
        return matriz;


    }
    
}
