public class TuringMachine {

    int CONT;
    char FITA[];

    public void Iniciar(String SEQUENCIA) {
        CONT = 0;
        FITA = SEQUENCIA.toCharArray();
        q0(); 
    }

    public void q0() {
    	if (CONT < FITA.length) {
            if (FITA[CONT] == ' ') { 
                FITA[CONT] = ' '; 
                CONT++; 
                q1(); 
            } else {
                qerro(); 
            }
        } else {
            qerro(); 
        }
    }
        
    public void q1() {
        if (CONT < FITA.length) {
            if (FITA[CONT] == 'B') {
                FITA[CONT] = 'B'; 
                CONT++; 
                q9();
            } else if (FITA[CONT] == 'A') {
                FITA[CONT] = 'A';
                CONT++;
                q9();
            } else if (FITA[CONT] == 'b') {
                FITA[CONT] = 'B';
                CONT++;
                q5();
            } else if (FITA[CONT] == 'a') {
                FITA[CONT] = 'A';
                CONT++;
                q2();
            }
            else {
                qerro();
            }
        } else {
            qerro();
        }
    }

    public void q2() {
        if (CONT < FITA.length) {
            if (FITA[CONT] == 'b') {
                FITA[CONT] = 'b';
                CONT++;
                q2();
            } else if (FITA[CONT] == 'a') {
                FITA[CONT] = 'a';
                CONT++;
                q2();
            } else if (FITA[CONT] == 'B') {
                FITA[CONT] = 'B';
                CONT--;
                q3();
            }else if (FITA[CONT] == 'A') {
                FITA[CONT] = 'A';
                CONT--;
                q3();
            }else if (FITA[CONT] == ' ') {
                FITA[CONT] = ' ';
                CONT--;
                q3();
            }
            else {
                qerro();
            }
        } else {
            qerro();
        }
    }

    public void q3() {
        if (CONT < FITA.length) {
            if (FITA[CONT] == 'A') {
                FITA[CONT] = 'A';
                CONT++;
                q4();
            } else if (FITA[CONT] == 'a') {
                FITA[CONT] = 'A';
                CONT--;
                q8();
            } 
            else {
                qerro();
            }
        } else {
            qerro();
        }
    }

    public void q4() {
        String PALAVRA = "";
        for (int i = 0; i < (FITA.length - 1); i++)
            PALAVRA = PALAVRA + Character.toLowerCase(FITA[i]);
        System.err.println(PALAVRA +" é um palíndromo. \n");
    }
    
    public void q5() {
    	 if (CONT < FITA.length) {
             if (FITA[CONT] == 'b') {
                 FITA[CONT] = 'b';
                 CONT++;
                 q5();
             } else if (FITA[CONT] == 'a') {
                 FITA[CONT] = 'a';
                 CONT++;
                 q5();
             } 
             else if (FITA[CONT] == 'B') {
                 FITA[CONT] = 'B';
                 CONT--;
                 q6();
             } 
             else if (FITA[CONT] == 'A') {
                 FITA[CONT] = 'A';
                 CONT--;
                 q6();
             } else if (FITA[CONT] == ' ') {
                 FITA[CONT] = ' ';
                 CONT--;
                 q6();
             } 
             else {
                 qerro();
             }
         } else {
             qerro();
         }
     }
      
    public void q6() {
    	 if (CONT < FITA.length) {
             if (FITA[CONT] == 'B') {
                 FITA[CONT] = 'B';
                 CONT++;
                 q7();
             } else if (FITA[CONT] == 'b') {
                 FITA[CONT] = 'B';
                 CONT--;
                 q8();
             } 
             else {
                 qerro();
             }
         } else {
             qerro();
         }
    }
    
    public void q7() {
    	String PALAVRA = "";
        for (int i = 0; i < (FITA.length - 1); i++)
            PALAVRA = PALAVRA + Character.toLowerCase(FITA[i]);
        System.err.println(PALAVRA +" É UM PALINDROMO! \n");
    }
    
    public void q8() {
    	 if (CONT < FITA.length) {
             if (FITA[CONT] == 'b') {
                 FITA[CONT] = 'b';
                 CONT--;
                 q8();
             } else if (FITA[CONT] == 'a') {
                 FITA[CONT] = 'a';
                 CONT--;
                 q8();
             } else if (FITA[CONT] == 'B') {
                 FITA[CONT] = 'B';
                 CONT++;
                 q1();
             } else if (FITA[CONT] == 'A') {
                 FITA[CONT] = 'A';
                 CONT++;
                 q1();
             } 
             else {
                 qerro();
             }
         } else {
             qerro();
         }
    }
    
    public void q9() {
    	 if (CONT < FITA.length) {
             if (FITA[CONT] == 'B') {
                 FITA[CONT] = 'B';
                 CONT++;
                 q9();
             } else if (FITA[CONT] == 'A') {
                 FITA[CONT] = 'A';
                 CONT++;
                 q9();
             } else if (FITA[CONT] == ' ') {
                 FITA[CONT] = ' ';
                 CONT--;
                 q10();
             }
             else {
                 qerro();
             }
         } else {
             qerro();
         }
    }
    
    public void q10() {
    	 String PALAVRA = "";
         for (int i = 0; i < (FITA.length - 1); i++)
             PALAVRA = PALAVRA + Character.toLowerCase(FITA[i]);
         System.err.println(PALAVRA +" É UM PALINDROMO! \n");
    }

    public void qerro() {
        String PALAVRA = "";
        for (int i = 0; i < (FITA.length); i++)
            PALAVRA = PALAVRA + Character.toLowerCase(FITA[i]);
        System.err.println(PALAVRA + " NÃO É UM PALINDROMO! \n");
    }
}
