package quizApi.springbootrestapi.models;
import java.util.List;

public class DisneyApiModel {
    private List<DisneyCharacterModel> data;

    private int count;

    private int totalPages;

    private String nextPage;


    public DisneyApiModel() {
    }

    public List<DisneyCharacterModel> getData() {
        return data;
    }

    public void setData(List<DisneyCharacterModel> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

}
