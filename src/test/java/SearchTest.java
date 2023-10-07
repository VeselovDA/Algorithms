import org.example.search.MyObjForWidthSearch;
import org.example.search.SearchUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest {
    private static final int[] sortedArray={1,2,3,5,6,7,8,9};

    @Test
    @DisplayName("Бинарный поиск")
    void binarySearchTest(){
        Assertions.assertEquals(-1,SearchUtils.binarySearch(sortedArray,4));
        int expectedIndex=1;
        Assertions.assertEquals(expectedIndex,SearchUtils.binarySearch(sortedArray,2));
    }

    @Test
    @DisplayName("Поиск в ширину")
    void widthSearchTest(){
        MyObjForWidthSearch found=SearchUtils.widthSearch(createTestDataForWidthSearch());
        Assertions.assertEquals("Natasha",found.getName());
    }

    private static MyObjForWidthSearch createTestDataForWidthSearch(){
        MyObjForWidthSearch myObjForWidthSearch=new MyObjForWidthSearch("Dmitriy",false,
                new MyObjForWidthSearch[]{
                        new MyObjForWidthSearch("Petya", false, new MyObjForWidthSearch[]{}),
                        new MyObjForWidthSearch("Vasya", false, new  MyObjForWidthSearch[]{
                                new MyObjForWidthSearch("Natasha", true,  new MyObjForWidthSearch[]{})})
                });
        myObjForWidthSearch.getSubArray()[0]
                .setSubArray(
                        new MyObjForWidthSearch[]{myObjForWidthSearch});//для проверки зацикленности поиска в ширину
        return myObjForWidthSearch;
    }
}
