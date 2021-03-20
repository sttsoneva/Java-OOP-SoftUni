package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unit = super.getData()[1];

        try {
            super.getRepository().removeUnit(unit);
            return unit + " retired!";
        } catch (IllegalArgumentException | ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
    }
}
