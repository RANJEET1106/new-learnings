package org.infosys;


import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    CalculationUtil calculationUtil;
    @BeforeAll
    static void beforeAllInit()
    {
        System.out.println("Before all testcase");
    }

    @BeforeEach
    void init(){
        System.out.println("Before Every test case");
        calculationUtil = new CalculationUtil();
    }

    @AfterEach
    void cleanUpCode(){
        System.out.println("After every test case");
    }

    @AfterAll
    static void afterAllInit(){
        System.out.println("After all test case");
    }

    @Test
    @DisplayName("SampleTest")
    void testShow(){
        System.out.println("Hello World");
    }

    @Test
    @DisplayName("AddInt")
    void testAdd(){
        CalculationUtil calculationUtil = new CalculationUtil();
        int actual=calculationUtil.add(10,20);
        int expected=30;
        Assertions.assertEquals(expected,actual,"Not equal values");
    }

    @Test
    @DisplayName("Multiply Test")
    void testMultiply(){
        CalculationUtil calculationUtil = new CalculationUtil();
        int actual=calculationUtil.multiply(10,20);
        int expected=200;
        Assertions.assertEquals(expected,actual,"Not equal values");
    }

    @Test
    @DisplayName("AssertAll in Multiple Test")
    void testMultiply1(){
        int actual=calculationUtil.multiply(0,20);
        int actual2=calculationUtil.multiply(-2,-2);
        Assertions.assertEquals(0,actual,"Not equal values");
        Assertions.assertEquals(4,actual2,"Not equal values");
        Assertions.assertAll(
                () -> Assertions.assertEquals(0,calculationUtil.multiply(0,4)),
                ()-> Assertions.assertEquals(4,calculationUtil.multiply(-2,-2)),
                () -> Assertions.assertEquals(-2,calculationUtil.multiply(-2,1))
        );
    }

    @Test
    @DisplayName("Failing Test")
    @Disabled
    void testFail(){
        Assertions.fail("this test always fail");
    }

    @RepeatedTest(3)
    @DisplayName("Repetation Test")
    void myTest(RepetitionInfo repetitionInfo){
        System.out.println(repetitionInfo.getCurrentRepetition());

        Assertions.assertEquals("Hi","Hi");
    }

    @Test
    void testNullString(){
        CalculationUtil calculationUtil = new CalculationUtil();
        String input="1234";
//        String input=null;
        String result= calculationUtil.parseString(input);
        Assertions.assertNotNull(result,"result is null");
    }

    @Test
    void testDivException(){
        CalculationUtil calculationUtil = new CalculationUtil();
//        Assertions.assertThrows(ArithmeticException.class, () -> calculationUtil.divide(10,0));
        Assertions.assertDoesNotThrow(() -> calculationUtil.divide(10,2),"error in code");
    }

    @Test
    void isSame(){
        String a="a";
        String b="a";
//        String s1=new String("abc");
//        String s2=new String("abc");
        Assertions.assertSame(a,b);

//        Assertions.assertSame(s1,s2);
    }
}
