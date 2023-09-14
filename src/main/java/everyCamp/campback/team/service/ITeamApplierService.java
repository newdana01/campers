package everyCamp.campback.team.service;

public interface ITeamApplierService {
    void approveMember(String teamId, String userId, boolean approveOrDeny);

}
