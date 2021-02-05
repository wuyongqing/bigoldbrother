import java.util.Arrays;
import java.util.List;

/**
 * 告警渠道
 */
public enum AlarmMemberEnum {

    DEVELOPMENT(Arrays.asList("qretos", "actorwang", "vito", "damon", "tristanwu", "june", "roman"));

    private List members;

    <T> AlarmMemberEnum(List<T> members) {
        this.members = members;
    }

    public List getMembers() {
        return this.members;
    }

}