package com.zoerAleksandr.lesson6;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 22.03.2021 1:23
 */
class Plate {
    private int leftover; // текущее количество еды в тарелке
    private int vol; // объем тарелки

    Plate(int vol) {
        this.vol = vol;
    }

    /*Метод добавления еды в тарелку.
     * К остатку в тарелке (leftover) добавляется указанное количество еды (count)
     * Если сумма leftover и count (x) меньше объема тарелки (vol), возвращается x,
     * В противном случает тарелка заполняется и считается полной, возвращается vol*/
    void append(int count) {
        int x = this.leftover + count;
        if (this.vol - x >= 0) this.leftover += count;
        else this.leftover = vol;
    }

    /*Метод уменьшает количество еды в тарелке.
     * Если остаток больше, чем требуемое количество, снижается остаток и возвращаетя его значение
     * В противном случае, возвращается остаток без изменения*/
    void eating(int count) {
        if (this.leftover - count >= 0) this.leftover -= count;
    }

    int getLeftover() {
        return leftover;
    }
}
