package rock.paper.scissors.common.params;

public class UserCriteria {

    private String userId;

    public UserCriteria(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
