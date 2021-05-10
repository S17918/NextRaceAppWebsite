package next.race.app.nextrace.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URL;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CategoryName;
    private URL CategoryLogo;
    private URL CategoryOfficialCalendarURL;
    private String CategoryHexColor;

    public Category(String categoryName, URL categoryLogo, URL categoryOfficialCalendarURL, String categoryHexColor) {
        CategoryName = categoryName;
        CategoryLogo = categoryLogo;
        CategoryOfficialCalendarURL = categoryOfficialCalendarURL;
        CategoryHexColor = categoryHexColor;
    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public URL getCategoryLogo() {
        return CategoryLogo;
    }

    public void setCategoryLogo(URL categoryLogo) {
        CategoryLogo = categoryLogo;
    }

    public URL getCategoryOfficialCalendarURL() {
        return CategoryOfficialCalendarURL;
    }

    public void setCategoryOfficialCalendarURL(URL categoryOfficialCalendarURL) {
        CategoryOfficialCalendarURL = categoryOfficialCalendarURL;
    }

    public String getCategoryHexColor() {
        return CategoryHexColor;
    }

    public void setCategoryHexColor(String categoryHexColor) {
        CategoryHexColor = categoryHexColor;
    }
}
