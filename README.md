# transit-ajax

transit encoding is used in
 - webserver ring middleware (muuntaja)
 - cljs ajax requests
 - websocket (sente packer)
 - websocket flowy
 
# test

```
cd demo

*cljs*
clj -X:npm-install
clj -X:ci
npm test

*clj*
clj -M:test-clj
```
