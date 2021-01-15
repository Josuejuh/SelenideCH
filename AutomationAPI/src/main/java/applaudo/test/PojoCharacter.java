package applaudo.test;

public class PojoCharacter
{
    public String char_id;
    public String name;
    public String birthday;
    public String[] occupation;
    public String img;
    public String status;
    public String nickname;
    public int [] appearance;
    public String portrayed;
    public String category;
    public int [] better_call_saul_appearance;

    public PojoCharacter() {

    }

    public PojoCharacter(String char_id, String name, String birthday, String[] occupation, String img, String status, String nickname, int[] appearance, String portrayed, String category, int[] better_call_saul_appearance) {
        this.char_id = char_id;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.status = status;
        this.nickname = nickname;
        this.appearance = appearance;
        this.portrayed = portrayed;
        this.category = category;
        this.better_call_saul_appearance = better_call_saul_appearance;
    }

    public String getChar_id() {
        return char_id;
    }

    public void setChar_id(String char_id) {
        this.char_id = char_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getOccupation() {
        return occupation;
    }

    public void setOccupation(String[] occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int[] getAppearance() {
        return appearance;
    }

    public void setAppearance(int[] appearance) {
        this.appearance = appearance;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int[] getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }

    public void setBetter_call_saul_appearance(int[] better_call_saul_appearance) {
        this.better_call_saul_appearance = better_call_saul_appearance;
    }
}
