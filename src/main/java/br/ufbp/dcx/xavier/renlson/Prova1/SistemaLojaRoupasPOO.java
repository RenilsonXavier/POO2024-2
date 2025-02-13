package br.ufbp.dcx.xavier.renlson.Prova1;

import java.util.HashMap;
import java.util.Map;

public class SistemaLojaRoupasPOO {
    private Map<String, Roupa> roupasMap;

    public SistemaLojaRoupasPOO(){
        this.roupasMap = new HashMap<>();
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException{
        if (this.roupasMap.containsKey(codigoRoupa)){
            throw new RoupaJaExisteException("Roupa já cadastrada: " + codigoRoupa);
        }else {
            Roupa roupa = new Roupa(codigoRoupa, descricao, tamanho, quantidade,);
            this.roupasMap.put(codigoRoupa, roupa);
        }
    }
}
