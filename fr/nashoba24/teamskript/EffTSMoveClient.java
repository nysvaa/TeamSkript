package fr.nashoba24.teamskript;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffTSMoveClient extends Effect {
	
	private Expression<Client> client;
	private Expression<Integer> channel;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		client = (Expression<Client>) expr[0];
		channel = (Expression<Integer>) expr[1];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean b) {
		return "ts3 move client";
	}
	
	@Override
	protected void execute(Event e) {
		if(TeamSkript.ts3api==null || client.getSingle(e)==null) { return; }
		TeamSkript.ts3api.moveClient(client.getSingle(e).getId(), channel.getSingle(e));
	}
}
