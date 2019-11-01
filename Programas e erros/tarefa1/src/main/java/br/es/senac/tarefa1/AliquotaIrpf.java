
package br.es.senac.tarefa1;

import javax.swing.JOptionPane;


public class AliquotaIrpf {
    public static void main(String[] args) {
        
    
 
        
    
 String entrada=JOptionPane.showInputDialog("Entre com o salário");
  int entrada2= Integer.parseInt(entrada);
        
    
    int renda =entrada2;
    

    
      
	double IR,Aliquota;
       System.out.println(renda);
	if(renda<=1903.98) {
		Aliquota=0;
     
		IR = ((renda*Aliquota);
	}else if(renda>1903.98 && renda<2826.65) {
		Aliquota=7.5/100;
		IR = ((renda*Aliquota);
	}else if(renda>2826.66 && renda<3751.05) {
		Aliquota=15/100;
		IR = ((renda*Aliquota);
	}else if(renda>3751.06 && renda<4664.68) {
		Aliquota=22.5/100;
		IR = ((renda*Aliquota);
	}else {
		Aliquota=27.5/100;
		IR = ((renda*Aliquota);
	}
          System.out.println(IR);
        
}
}
