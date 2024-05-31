import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;


public class MaquinaTuringTest {
   
    
	@Test
    public void test1() {
        TuringMachine MAQ = new TuringMachine();
        MAQ.Iniciar(" abba ");
	}
	@Test
    public void test2() {
		 TuringMachine MAQ = new TuringMachine();
		 MAQ.Iniciar(" aaaaaaa ");
	}
	@Test
    public void test3() {
		TuringMachine MAQ = new TuringMachine();
		 MAQ.Iniciar(" ababa ");
	}
	@Test
    public void test4() {
		TuringMachine MAQ = new TuringMachine();
		  MAQ.Iniciar(" bbbbbbbbbbbbb ");
	}
	@Test
    public void test5() {
		TuringMachine MAQ = new TuringMachine();
		  MAQ.Iniciar(" baaab ");
	}
	@Test
    public void test6() {
		TuringMachine MAQ = new TuringMachine();
		  MAQ.Iniciar(" baaaaaaaaaaab ");
	}
	
	@Test
    public void test7() {
		TuringMachine MAQ = new TuringMachine();
		  MAQ.Iniciar(" bba ");
	}
	@Test
    public void test8() {
		TuringMachine MAQ = new TuringMachine();
	        MAQ.Iniciar(" abbb ");

	}
	@Test
    public void test9() {
		TuringMachine MAQ = new TuringMachine();	
	        MAQ.Iniciar(" bbbaaa ");

	}
	@Test
    public void test10() {
		TuringMachine MAQ = new TuringMachine(); 
	        MAQ.Iniciar(" aabbbb ");

	}
	@Test
    public void test11() {
		TuringMachine MAQ = new TuringMachine();
	        MAQ.Iniciar(" babababa ");

	}
        
    }

