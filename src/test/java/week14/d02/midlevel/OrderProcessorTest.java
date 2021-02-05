package week14.d02.midlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderProcessorTest {

    OrderProcessor op = new OrderProcessor();

    public static final String SEARCHED_ID = "b341";
    public static final String SEARCHED_GOODS = "sugar";

    @BeforeEach
    void setUp() {
        op.readFileFromResources();
    }

    @Test
    void getOrderedGoodsById() {
        assertEquals("[basil, cheese, passata, pasta]", op.getOrderedGoodsById(SEARCHED_ID).toString());
    }

    @Test
    void getCountOfGoodsByName() {
        assertEquals(3, op.getCountOfGoodsByName(SEARCHED_GOODS));
    }

    @Test
    void getOrderedGoodsCountById() {
        assertEquals(4, op.getOrderedGoodsCountById(SEARCHED_ID));
    }

    @Test
    void reportOfOrderedGoods() {
        assertEquals("{apple=1, basil=1, bbq_sauce=1, beer=2, bread=1, carrot=1, cheese=2, chips=1, cola=1, corn=1, flour=1, hot_dog=1, meet=2, oregano=1, passata=2, pasta=2, pear=1, pepper=1, pizza_dough=1, potato=1, rolls=1, rosmary=2, salt=1, soda=2, sugar=3, tomato=2, wine=1}",
                op.reportOfOrderedGoods().toString());
    }
}