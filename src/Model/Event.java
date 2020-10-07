package Model;

public class Event {
    private String introduction = "---";
    private Choice[] allChoices = new Choice[0];

    public void insertNewChoice() {
        Choice[] tmpChoiceArr = new Choice[allChoices.length + 1];
        for (int i = 0; i < allChoices.length; i++) {
            tmpChoiceArr[i] = allChoices[i];
        }
        tmpChoiceArr[tmpChoiceArr.length - 1] = new Choice();
        allChoices = tmpChoiceArr;
    }

    public void deleteChoiceByIndex(int index) {
        if (index < allChoices.length && index >= 0) {
            Choice[] tmpChoiceArr = new Choice[allChoices.length - 1];
            int x = 0;
            for (int i = 0; i < tmpChoiceArr.length; i++) {
                if (i == index) x = 1;
                tmpChoiceArr[i] = allChoices[i + x];
            }
            allChoices = tmpChoiceArr;
        }
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Choice[] getAllChoices() {
        return allChoices;
    }
}
