package fr.nashoba24.teamskript;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffTSBroadcastMessage extends Effect {
	
	private Expression<String> msg;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		msg = (Expression<String>) expr[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean b) {
		return "ts3 broadcast";
	}
	
	@Override
	protected void execute(Event e) {
		if(TeamSkript.ts3api != null) {
			TeamSkript.ts3api.broadcast(msg.getSingle(e));
		}
		else {
			TeamSkript.getInstance().getLogger().severe("You are not connected to a Teamspeak server!");
		}
	}
}
