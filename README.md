###概要

OpenECHOは、家電やセンサーデバイスなど、スマートハウスで用いられる機器のための通信プロトコルである[ECHONET Lite][]をJavaで実装したドライバライブラリです([C++版][]もあります)。
詳細規定が存在する全ての機器+コントローラの制御が可能です。ネットワーク上の機器を認識して通信することができるのみならず、機器クラスを継承することでオリジナルの機器ノードを作成することもできます。分電盤・コントローラ・エアコン・照明・蓄電池・エコキュート・電動ブラインドなどの実動実績があります（とりあえず動いたレベルですが）。
現在、ECHONET Lite対応機器としてECHONETコンソーシアムに認証された機器のリストが[こちらにあります](http://www.echonet.gr.jp/kikaku_ninsyo/list_lite/equip_srch)。2014年4月時点ですでに160種類以上の機器が受理されている模様です。

※ただし、あくまでコンソーシアムが認証した機器のリストであって、すでに市場に出回っているかどうかはわかりません。OpenECHOもこれら全ての機器の動作を保証するものではありません。というか、どの機器の動作も保証いたしません。

OpenECHOを用いて実装されたAndroidホームサーバー「Kadecot」による[動作実験ビデオ](http://www.youtube.com/watch?v=SwpHSAvoV9I)があります。

###ライセンス
本ソフトウェアの著作権は[株式会社ソニーコンピュータサイエンス研究所][]が保持しており、GPL3ライセンスで配布されています。ライセンスに従い，自由にご利用ください。

###ドキュメンテーションとProcessing用バイナリ

本ライブラリは、Processing Foundationにより配布されている[Processing][]からも利用しやすいように構成されています。
このProcessing版のサンプル開発・ドキュメンテーションは神奈川工科大学　スマートハウス研究センター　エネルギーマネジメントシステム標準化における接続・制御技術研究事業の成果物です。Processing版を使いやすくまとめたものが[神奈川工科大学スマートハウス研究センター][]からも配布されています。

Processing版はProcessing/フォルダの下にあります。
こちらはOpenECHO/ECHONET Liteの入門用としても最適です。チュートリアルが[OpenECHO for Processing/Tutorial.pdf](https://github.com/SonyCSL/OpenECHO/blob/master/Processing/Tutorial.pdf?raw=true)にありますのでぜひご利用ください。[英語版もあります](https://github.com/SonyCSL/OpenECHO/blob/master/Processing/Tutorial-en.pdf?raw=true)。

###バージョン

* tag [1.10_ReleaseC](https://github.com/SonyCSL/OpenECHO/releases/tag/1.10_ReleaseC)がECHONET Lite規格書の[Version 1.10](http://www.echonet.gr.jp/spec/spec_v110_lite.htm), 機器オブジェクト詳細規定の[Release C](http://www.echonet.gr.jp/spec/spec_app_c.htm)に対応しています。

###用いているデータベース
本ライブラリの作成には、弊社から公開されている[ECHONET Liteデータベース][]を用いています。
[ECHONET Liteデータベース][]の最新仕様へのアップデート・やフィードバックも随時募集しています。データベースのライセンスはパブリックドメインですのでぜひご協力ください。

###互換性と動作レポート
OpenECHOは標準的なJavaの機能だけで実装されており、Windows, Linux, Mac, Androidなど様々な環境での動作実績があります。

以下勝手にリンクしていますので、問題があればお知らせください。
* [Howto : ArmadilloでECHONET Lite (まとめ)](http://armadillo.atmark-techno.com/howto/OpenECHO)
* [KS Labo LED照明省エネコントローラ(スマートハウス実験)](http://www.tsh-world.co.jp/ks/product/radio/ks_hems.html)
* [Kadecot (ARレイちゃん）によるECHONET Lite対応照明制御デモ (YouTube)](https://www.youtube.com/watch?v=id3cMefV9Oo)
* [何かができたらとりあえずまとめるブログ openECHO！ホームネットワーク機器と化したラズパイ](http://ch.nicovideo.jp/issekiamp/blomaga/ar327030)
* [MUDAなことをしよう。Raspberry Pi + OpenECHOでLチカ](http://make-muda.weblike.jp/2014/02/751/)
* [手作り照明をECHONET Lite対応（笑）/ヒビコレ](http://magicbike.hatenablog.com/entries/2013/10/06)


[ECHONET Lite]: http://www.echonet.gr.jp/ "ECHONET Lite"
[C++版]: https://github.com/SonyCSL/OpenECHO-cpp "OpenECHO-cpp"
[株式会社ソニーコンピュータサイエンス研究所]: http://www.sonycsl.co.jp/ "株式会社ソニーコンピュータサイエンス研究所"
[MITライセンス]: http://opensource.org/licenses/mit-license.php "MITライセンス"
[Processing]: http://processing.org "Processing"
[神奈川工科大学スマートハウス研究センター]: http://smarthouse-center.org/sdk/ "神奈川工科大学スマートハウス研究センター"
[ECHONET Liteデータベース]: https://github.com/SonyCSL/ECHONETLite-ObjectDatabase "ECHONET Liteデータベース"
