package program.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.common.ConfigCommon;
import program.common.dummydata.NumberDummy;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CalculatedOnArray Testing")
class CalculatedOnArrayTest {

    @Test
    @DisplayName("Expected findMin return -1 When array null")
    void findMin_Success_01() {
        //given
        Integer[] array = null;

        //when
        int result  = CalculatedOnArray.findMin(array);

        //then
        assertEquals(result, -1);
    }

    @Test
    @DisplayName("Expected findMin return -1 When array empty")
    void findMin_Success_02() {
        //given
        Integer[] array = new Integer[0];

        //when
        int result  = CalculatedOnArray.findMin(array);

        //then
        assertEquals(result, -1);
    }

    @Test
    @DisplayName("Expected findMin return value min When array has value")
    void findMin_Success_03() {
        //given
        Integer[] array = NumberDummy.intArrays(20);
        ConfigCommon.printArray(array);
        IntSummaryStatistics statistics = Arrays.stream(array).collect(Collectors.summarizingInt(s->s));
        int expectedMin = statistics.getMin();

        //when
        int result  = CalculatedOnArray.findMin(array);

        //then
        assertEquals(expectedMin, result);
    }

    @Test
    @DisplayName("Expected findMinSecond return -1 When array null")
    void findMinSecond_Success_01() {
        //given
        Integer[] array = null;

        //when
        int result  = CalculatedOnArray.findMinSecond(array);

        //then
        assertEquals(result, -1);
    }

    @Test
    @DisplayName("Expected findMinSecond return -1 When array empty")
    void findMinSecond_Success_02() {
        //given
        Integer[] array = new Integer[0];

        //when
        int result  = CalculatedOnArray.findMinSecond(array);

        //then
        assertEquals(result, -1);
    }

   @Test
   @DisplayName("Expected findMinSecond return true When array have data")
    void findMinSecond() {
       //given
       final Integer[] array = NumberDummy.intArrays();
       Integer[] array2 = new Integer[array.length];

       array2 = Arrays.stream(array).map(s -> s).collect(Collectors.toList()).toArray(array2);
       IntSummaryStatistics statistics = Arrays.stream(array).collect(Collectors.summarizingInt(s->s));
       int min = statistics.getMin();

       List<Integer> arrayRemoveMinMax = Arrays.stream(array).filter(item -> !item.equals(min)).collect(Collectors.toList());
       IntSummaryStatistics statistics2 = arrayRemoveMinMax.stream().collect(Collectors.summarizingInt(s->s));
       int min2 = statistics2.getMin();

       //when
       int result  = CalculatedOnArray.findMinSecond(array2);

       //then
       assertEquals(min2, result);
    }

    @Test
    @DisplayName("Expected findMinThird return true When array have data")
    void findMinThird() {
        //given
        final Integer[] array = NumberDummy.intArrays();
        Integer[] array2 = new Integer[array.length];
        array2 = Arrays.stream(array).map(s -> s).collect(Collectors.toList()).toArray(array2);
        IntSummaryStatistics statistics = Arrays.stream(array).collect(Collectors.summarizingInt(s->s));

        List<Integer> arrayRemoveMinMax = Arrays.stream(array).filter(item -> !item.equals(statistics.getMin())).collect(Collectors.toList());
        IntSummaryStatistics statistics2 = arrayRemoveMinMax.stream().collect(Collectors.summarizingInt(s->s));

        List<Integer> arrayRemoveMinSecond = arrayRemoveMinMax.stream().filter(item -> !item.equals(statistics2.getMin())).collect(Collectors.toList());
        IntSummaryStatistics statistics3= arrayRemoveMinSecond.stream().collect(Collectors.summarizingInt(s->s));
        int min3 = statistics3.getMin();

        //when
        int result  = CalculatedOnArray.findMinThird(array2);

        //then
        assertEquals(min3, result);
    }

    @Test
    @DisplayName("Expected findMax find -1 correct when array empty")
    void findMax_Success_01() {
        //given
        Integer[] arrayInput = new Integer[0];
        Integer expectedMax = -1;

        // when
        Integer result = CalculatedOnArray.findMax(arrayInput);

        //then
        assertEquals(expectedMax, result);
    }

    @Test
    @DisplayName("Expected findMax find -1 correct when array null")
    void findMax_Success_02() {
        //given
        Integer[] arrayInput = null;
        Integer expectedMax = -1;

        // when
        Integer result = CalculatedOnArray.findMax(arrayInput);

        //then
        assertEquals(expectedMax, result);
    }

   @Test
   @DisplayName("Expected findMax find value correct when array not empty")
    void findMax_Success_03() {
       //given
       Integer[] arrayInput = NumberDummy.intArrays();
       Integer expectedMax = Arrays.stream(arrayInput).collect(Collectors.summarizingInt(s->s)).getMax();

       // when
       Integer result = CalculatedOnArray.findMax(arrayInput);

       //then
       assertEquals(expectedMax, result);
    }

   @Test
   @DisplayName("Expected findMaxSecond return -1 when array empty")
    void findMaxSecond_Success_01() {
       // given
       Integer expected = -1;

       // then
       Integer result = CalculatedOnArray.findMaxSecond(new Integer[0]);

       // when
       assertEquals(expected, result);
    }

    @Test
    @DisplayName("Expected findMaxSecond return -1 when array null")
    void findMaxSecond_Success_02() {
        // given
        Integer expected = -1;

        // then
        Integer result = CalculatedOnArray.findMaxSecond(null);

        // when
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Expected findMaxSecond return value second when array exist")
    void findMaxSecond_Success_03() {
        // given
        Integer[] array = NumberDummy.intArrays();
        Integer max = Arrays.stream(array).collect(Collectors.summarizingInt(s -> s)).getMax();

        List<Integer> arrayAfterRemoveMax = Arrays.stream(array).filter(s -> !s.equals(max)).collect(Collectors.toList());
        Integer maxSecond = arrayAfterRemoveMax.stream().collect(Collectors.summarizingInt(s -> s)).getMax();

        // then
        Integer result = CalculatedOnArray.findMaxSecond(array);

        // when
        assertEquals(maxSecond, result);
    }

   @Test
    void printEven() {
    }

   @Test
    void printOdd() {
    }

   @Test
    void printReserveOrder() {
    }

   @Test
    void sum() {
    }

   @Test
    void sort() {
    }


    @Test
    @DisplayName("Testing loop")
    void main() {
        for(int i=0; i< 500; i++){
            System.out.println("findMinSecond() ");
            findMinSecond();
            System.out.println("findMinThird() ");
            findMinThird();
            System.out.println("findMax() ");
            findMax_Success_03();
            System.out.println("findMaxSecond_Success_03() ");
            findMaxSecond_Success_03();
        }
    }
}