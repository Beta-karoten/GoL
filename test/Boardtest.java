import com.company.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Boardtest {

    private Board test;
    @BeforeEach
    public void Boardinit(){
        test = new Board(6);
    }
    @Test
    public void BoardCornerTest(){
        test.setlife(0,1);
        test.setlife(0,0);
        test.setlife(1,0);
        test.setlife(1,1);
        Assertions.assertEquals(3, test.neighbourscount(0,0));
    }
    @Test
    public void BoardEdgeTest(){
        test.setlife(2,0);
        test.setlife(2,1);
        test.setlife(3,0);
        test.setlife(3,1);
        test.setlife(4,0);
        test.setlife(4,1);
        Assertions.assertEquals(5,test.neighbourscount(3,0));
    }
    @Test
    public void BoardTest(){
        test.setlife(2,2);
        test.setlife(1,3);
        test.setlife(3,1);
        test.setlife(5,5);
        Assertions.assertEquals(2, test.neighbourscount(2,2));
    }
    @Test
    public void LifeTest1(){
        test.setlife(2,2);
        test.setlife(3,2);
        Assertions.assertEquals(false,test.update(3,2));
    }
    @Test
    public void LifeTest2(){
        test.setlife(2,2);
        test.setlife(2,3);
        test.setlife(3,2);
        Assertions.assertEquals(true,test.update(3,2));
    }
    @Test
    public void LifeTest3(){
        test.setlife(2,2);
        test.setlife(2,3);
        test.setlife(3,2);
        test.setlife(3,3);
        test.setlife(4,2);
        Assertions.assertEquals(false,test.update(3,2));
    }
    @Test
    public void LifeTest4(){
        test.setlife(3,4);
        test.setlife(4,4);
        test.setlife(5,4);
        Assertions.assertEquals(true,test.update(4,3));
    }

}
