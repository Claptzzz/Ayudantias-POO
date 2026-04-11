public class Receta {

    private String[][] patron;
    private String resultado;

    public Receta(String ingr1, String ingr2, String ingr3, String ingr4, String resultado){

        patron = new String[2][2];

        patron[0][0] = ingr1;
        patron[0][1] = ingr2;
        patron[1][0] = ingr3;
        patron[1][1] = ingr4;

        this.resultado = resultado;
    }

    public String getResultado(){
        return resultado;
    }

    public String[][] getPatron(){
        return patron;
    }

    @Override
    public String toString(){

        String receta = "";

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                receta += "[" + patron[i][j] + "]";
            }
            receta += "\n";
        }
        receta += "-> " + resultado;

        return receta;
    }

}