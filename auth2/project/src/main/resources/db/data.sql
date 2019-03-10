-- insert a default client credentials
insert into oauth_client_details
(client_id, client_secret, scope,
 authorized_grant_types, web_server_redirect_uri)
values
('mobileclient', '112233', 'read_userinfo,read_contacts',
'authorization_code,implicit,password', 'oauth2://userinfo/callback,http://localhost:9000/callback'
);

insert into oauth_client_details
(client_id, client_secret, scope,
 authorized_grant_types, web_server_redirect_uri)
values
('clientapp', '112233', 'read_userinfo,read_contacts',
'authorization_code,implicit,password', 'oauth2://userinfo/callback,http://localhost:9000/callback'
);
