package com.heika.test.utils;

import redis.clients.jedis.Jedis;

public class Redis {

	public boolean execute(String[] para) {

		boolean ret = false;

		if (para[0].equals("redisget")) {
			redisget(para);
			ret = true;
		} else if (para[0].equals("redisset")) {
			redisset(para);
			ret = true;
		}

		return ret;
	}

	public void redisget(String[] para) {

		String[] hostport = para[1].split(":");
		Jedis jedis = null;

		if (hostport.length == 2)

			jedis = new Jedis(hostport[0], Integer.valueOf(hostport[1]));

		else
			jedis = new Jedis(para[1]);

	}

	public void redisset(String[] para) {

		Jedis jedis = null;
		String[] hostport = para[1].split(":");

		if (hostport.length == 2)
			jedis = new Jedis(hostport[0], Integer.valueOf(hostport[1]));
		else
			jedis = new Jedis(para[1]);

		String result = "";

		if (para.length < 5)

			result = jedis.set(para[2], para[3]);
		else
			result = jedis.setex(para[2], Integer.valueOf(para[4]), para[3]);

	}

}
