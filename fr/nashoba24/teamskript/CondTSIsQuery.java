package fr.nashoba24.teamskript;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class CondTSIsQuery extends Condition {

    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "ts3 is connected";
    }

    @Override
    public boolean check(Event e) {
        if(TeamSkript.ts3api != null) {
        	return true;
        }
        else {
        	return false;
        }
    }

}