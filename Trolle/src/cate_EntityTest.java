import static org.junit.Assert.*;

import org.junit.Test;

public class cate_EntityTest {

	@Test
	public void test() {
		cate_Entity c=new cate_Entity();
		assertEquals("fail here", true, c.Delete(15));
		fail("Not yet implemented");
	}
	@Test
	public void tst() {
		cate_Entity c=new cate_Entity();

		assertEquals("fail ..",c,c.Select(15));
		fail("Not yet implemented");
	}

}
