package pl.sdacademy.unit.test.basic.exercises.tdd.task3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

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

    @Test
    void shouldNoyTransferMoneyIfAmountIsWrong() {
        //given
        float amount = 3000;
        Account credit = new Account(
                1000,
                "11111111111111111111111111",
                new Customer("aaa", "bbb"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("ccc", "ddd"));
        //when
        debit.transferMoney(credit, amount);
        //then
        assertThat(credit.getBalance()).isEqualTo(1000);
        assertThat(debit.getBalance()).isEqualTo(2000);
    }

    @Test
    void shouldNoyTransferMoneyIfAmountIsWrong_2() {
        //given
        float amount = 0;
        Account credit = new Account(
                1000,
                "11111111111111111111111111",
                new Customer("aaa", "bbb"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("ccc", "ddd"));
        //when
        debit.transferMoney(credit, amount);
        //then
        assertThat(credit.getBalance()).isEqualTo(1000);
        assertThat(debit.getBalance()).isEqualTo(2000);
    }

    @Test
    void shouldNoyTransferMoneyIfAmountIsWrong_3() {
        //given
        float amount = -100;
        Account credit = new Account(
                1000,
                "11111111111111111111111111",
                new Customer("aaa", "bbb"));
        Account debit = new Account(
                2000,
                "22222222222222222222222222",
                new Customer("ccc", "ddd"));
        //when
        debit.transferMoney(credit, amount);
        //then
        assertThat(credit.getBalance()).isEqualTo(1000);
        assertThat(debit.getBalance()).isEqualTo(2000);
    }

}