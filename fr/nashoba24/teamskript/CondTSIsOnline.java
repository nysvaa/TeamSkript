package fr.nashoba24.teamskript;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class CondTSIsOnline extends Condition {


    private Expression<Client> client;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
        client = (Expression<Client>) expr[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "client is online";
    }

    @Override
    public boolean check(Event e) {
    	if(TeamSkript.ts3api==null || client.getSingle(e)==null) { return false; }
    	if(!client.getSingle(e).isAway()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}