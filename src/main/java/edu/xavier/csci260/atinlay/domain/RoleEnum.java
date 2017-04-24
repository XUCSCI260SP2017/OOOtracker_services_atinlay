package edu.xavier.csci260.atinlay.domain;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/18/2017.
 */
public enum RoleEnum {
        WORKER,
        MANAGER,
        HR;
    RoleEnum() {}

    @Override
    public String toString() {
        return "ROLE_" + super.toString();
    }
}
