package giopollo.progetto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import giopollo.progetto.Exception.E_Between;
import giopollo.progetto.Exception.E_wordNotFound;
import giopollo.progetto.Model.Follower;
import giopollo.progetto.Request.Filter.Words;
import giopollo.progetto.Request.Filter.NumChar;


@SpringBootTest
class ProgettoOopApplicationTests {

	private Follower f1 = null;
	private Follower f2 = null;
	Words s = null;
	List<Follower> lf = null;
	NumChar n = null;
	
	
	@BeforeEach
	void setUp() throws Exception {
		n = new NumChar();
		lf = new ArrayList<Follower>();
		s = new Words();
		f1 = new Follower("Paolo","Ancona");
		f2 = new Follower("Michele","Castelferretti");
		lf.add(f1);
		lf.add(f2);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals("Paolo", f1.getName());
		assertEquals("Ancona", f1.getLocation());
	}
	
	
	@Test 
	void testException(){
		assertThrows(E_wordNotFound.class,()->{s.word(lf, "Milano");});
		
		ArrayList<Integer> ex = new ArrayList<Integer>();
		ex.add(10); ex.add(8);
		assertThrows(E_Between.class, ()->{n.between(lf, ex);});
	}
	
	@Test 
	void testLower(){
		lf = n.lower(lf, 2);
		assertTrue(lf.isEmpty());
	}
	
	@Test 
	void testGreater(){
		lf = n.greater(lf, 8);
		assertTrue(lf.size()==1);
	}
	
	@Test 
	void testBetween(){
		ArrayList<Integer> ex = new ArrayList<Integer>();
		ex.add(3); ex.add(8);
		lf = n.between(lf, ex);
		assertTrue(lf.size()==1);
	}

}
