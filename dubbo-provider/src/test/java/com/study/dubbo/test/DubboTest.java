package com.study.dubbo.test;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;

public class DubboTest {
	public static void main(String[] args) throws Exception {
		ACLProvider aclProvider = new ACLProvider() {
			private List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
			@Override
			public List<ACL> getDefaultAcl() {
                return acl;
			}
			
			@Override
			public List<ACL> getAclForPath(String path) {
				 return acl;
			}
		};
		
		CuratorFramework curator = CuratorFrameworkFactory.builder()
				.aclProvider(aclProvider)
				.connectString("192.168.134.134:2181")
				.retryPolicy(new RetryNTimes(3, 3000))
				.namespace("dubbo")
				.build();
		
		curator.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			@Override
			public void stateChanged(CuratorFramework client, ConnectionState state) {
				if (state == ConnectionState.LOST) {
                    System.out.println("连接丢失");
                } else if (state == ConnectionState.CONNECTED) {
                    System.out.println("连接新建"); 
                } else if (state == ConnectionState.RECONNECTED) {
                    System.out.println("连接重连");
                }  
			}
		});
		
		curator.start();
		
		curator.create()
			.creatingParentsIfNeeded()
			.withMode(CreateMode.EPHEMERAL)
			.inBackground(new BackgroundCallback() { //异步调用
				@Override
				public void processResult(CuratorFramework framework, CuratorEvent event) throws Exception {
					System.out.println("type=" + event.getType().name());
					//System.out.println("stat=" + event.getStat().toString());
					//System.out.println("data=" + new String(event.getData()));
					System.out.println("path=" + event.getPath());
					System.out.println("resultCode=" + event.getResultCode());
					System.out.println("name=" + event.getName());
					//System.out.println("children=" + event.getChildren().toString());
					//System.out.println("aclList=" + event.getACLList().toString());
				}
			})
			.forPath("/dubbo", "234".getBytes());
		
		System.out.println(new String(curator.getData().forPath("/dubbo")));
		
		curator.close();
		curator = null;
	}
	
}
