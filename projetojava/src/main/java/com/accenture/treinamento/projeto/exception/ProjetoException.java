package com.accenture.treinamento.projeto.exception;
public class ProjetoException extends Exception{
    public ProjetoException() {
    }
     public ProjetoException(String arg) {
        super(arg);    
    }

    public ProjetoException(Throwable arg) {
        super(arg);    
    }

    public ProjetoException(String arg,Throwable arg1){
        super(arg,arg1);
}

}
