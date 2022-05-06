package pl.sdacademy.unit.test.basic.exercises.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private int temp;

    @BeforeEach
    void init() {
        temp = 100;
    }

    @Test
    void shouldTransferMoney() {
        //given
        Account credit = new Account(
                1000,
                "11111111111111111111111111",
                new Customer("Jan", "Nowak"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("Ala", "Kowalska"));
        //when
        debit.transferMoney(credit, 100);
        //then
        assertEquals(1100, credit.getBalance());
        assertEquals(1900, debit.getBalance());
        assertThat(credit.getBalance()).isEqualTo(1100);
        assertThat(debit.getBalance()).isEqualTo(1900);
    }

    @Test
    void shouldNotTransferMoneyIfCreditAccountNumberIsWrong() {
        //given
        Account credit = new Account(
                1000,
                "1",
                new Customer("Jan", "Nowak"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("Ala", "Kowalska"));
        //when
        debit.transferMoney(credit, 100);
        //then
        assertEquals(1000, credit.getBalance());
        assertEquals(2000, debit.getBalance());
        assertThat(credit.getBalance()).isEqualTo(1000);
        assertThat(debit.getBalance()).isEqualTo(2000);
    }

    @Test
    void shouldNotTransferMoneyIfCreditAccountNumberIsWrong_2() {
        //given
        Account credit = new Account(
                1000,
                "111111111111111111111111111",
                new Customer("Jan", "Nowak"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("Ala", "Kowalska"));
        //when
        debit.transferMoney(credit, 100);
        //then
        assertEquals(1000, credit.getBalance());
        assertEquals(2000, debit.getBalance());
        assertThat(credit.getBalance()).isEqualTo(1000);
        assertThat(debit.getBalance()).isEqualTo(2000);
    }

    @Test
    void shouldNotTransferMoneyIfCreditAccountNumberIsWrong_3() {
        //given
        Account credit = new Account(
                1000,
                "aaaaaaaaaaaaaaaaaaaaaaaaaa",
                new Customer("Jan", "Nowak"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("Ala", "Kowalska"));
        //when
        debit.transferMoney(credit, 100);
        //then
        assertEquals(1000, credit.getBalance());
        assertEquals(2000, debit.getBalance());
        assertThat(credit.getBalance()).isEqualTo(1000);
        assertThat(debit.getBalance()).isEqualTo(2000);
    }

    /*
    walidacja amounta:
    amount = -100
    amount = 0
    amount większy od aktualny balanace na debit account -> debit.balance = 2000, amount = 3000
     */

}