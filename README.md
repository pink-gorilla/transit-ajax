# transit-ajax [![GitHub Actions status |pink-gorilla/transit-ajax](https://github.com/pink-gorilla/transit-ajax/workflows/CI/badge.svg)](https://github.com/pink-gorilla/transit-ajax/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/transit-ajax.svg)](https://clojars.org/org.pinkgorilla/transit-ajax)


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
