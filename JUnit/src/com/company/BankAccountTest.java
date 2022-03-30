package com.company;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class BankAccountTest {

    //instanced variable
    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases");
    }

    //setup code
    @org.junit.Before
    public void setup() {
        account = new BankAccount("Mike", "Howell", 1000, BankAccount.CHECKING);
        System.out.println("Running a test....");
    }

    @org.junit.Test
    public void deposit() throws Exception{
        double balance = account.deposit(200.00, true);
        //testing deposit
        assertEquals(1200, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception{
        double balance = account.withdraw(600, true);
        assertEquals(400.00, balance, 0);
    }

    //ATM withdrawal
    //Telling the method to expect the Illegal argument to pass test.
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600, false);
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception{
        account.deposit(200.00, true);
        //testing account balance / get balance
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception{
        account.withdraw(200.00, true);
        //testing account balance / get balance
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        //assertEquals(true, account.isChecking());
        // Proper method is below. if not a Checking account - it'll fail.

        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

    //Other junit methods to play with:
    //assertNotEquals(), assertArrayEquals(), assertNull() & NotNull(), assertSame() & NotSame(), assertThat()

}