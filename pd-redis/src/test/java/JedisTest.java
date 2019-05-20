import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class JedisTest {
	@Test	//��ɵ�ʵ������,�޸Ĵ�����ip��ַ
	public void jedis(){
		Jedis jedis = new Jedis("192.168.92.2", 7000);
		//jedis.auth("123456");
		jedis.set("name", "tony");	//����redis����set
		String s = jedis.get("name");
		System.out.println(s);
		jedis.close();
}
	//redis���Է�Ƭ
		@Test
		public void test02(){
			//2.������Ƭ�����ӳ�
			JedisPoolConfig poolConfig = new JedisPoolConfig();
			poolConfig.setMaxTotal(500);
			poolConfig.setMaxIdle(20);
			//3.׼��redis�ķ�Ƭ
			List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
			shards.add(new JedisShardInfo("192.168.92.2", 7000));
			shards.add(new JedisShardInfo("192.168.92.2", 7001));
			shards.add(new JedisShardInfo("192.168.92.2", 7002));
			//1.������Ƭ�Ķ���
			ShardedJedisPool jedisPool = 
					new ShardedJedisPool(poolConfig, shards);
			//��ȡjedis����
			ShardedJedis shardedJedis = jedisPool.getResource();
			//5.redis�Ĵ�ȡֵ����
			for (int i = 0; i < 9; i++) {
				shardedJedis.set("n"+i,"���Ƿ�Ƭ����"+i);
			}
		}
}
