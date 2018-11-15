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
public class Livro extends Publicacao{
    private int ISBN;
    
    /**
     *
     * @param titulo
     * @param autor
     * @param qnt_total
     * @param qnt_disp
     * @param isbn
     */
    public Livro(String titulo, String autor, int qnt_total, int qnt_disp, int isbn){
        super(titulo, autor, qnt_total, qnt_disp);
        this.ISBN = isbn;
    }

    /**
     * @return the ISBN
     */
    @Override
    public int getCodigo() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    @Override
    public void setCodigo(int ISBN) {
        this.ISBN = ISBN;
    }
    
}
