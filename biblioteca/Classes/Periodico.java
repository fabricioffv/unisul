/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Classes;

/**
 *
 * @author Fabricio
 */
public class Periodico extends Publicacao{
    private int ISSN;

   public Periodico(String titulo, String autor, int qnt, int qnt_disp, int issn){
        super(titulo, autor, qnt, qnt_disp);
        this.ISSN = issn;
    }

    /**
     * @return the ISSN
     */
     @Override
    public int getCodigo() {
        return ISSN;
    }

    /**
     * @param ISSN
     */
    @Override
    public void setCodigo(int ISSN) {
        this.ISSN = ISSN;
    }
    
}
