OpenECHOは、[ECHONET Lite][]プロトコルをJavaで実装したライブラリです。
現在、詳細規定が存在する全ての機器+コントローラで、合計90機器をサポートしています。
機器クラスを継承し、自分の機器ノードを作成することもできます。
分電盤・コントローラ・エアコン・照明については実機器での動作を確認しました。

※本ソフトウェアの著作権は[株式会社ソニーコンピュータサイエンス研究所][]が保持しており、[MITライセンス][]で配布されています。ライセンスに従い，自由にご利用ください。

本ライブラリは、Processing Foundationにより配布されている[Processing][]からも利用しやすいように構成されています。
このProcessing版のサンプル開発・ドキュメンテーションは神奈川工科大学　スマートハウス研究センター　エネルギーマネジメントシステム標準化における接続・制御技術研究事業の成果物です。Processing版を使いやすくまとめたものが[神奈川工科大学スマートハウス研究センター][]からも配布されています。

Processing版はProcessing/フォルダの下にあります。
こちらはOpenECHO/ECHONET Liteの入門用としても最適です。チュートリアルがOpenECHO for Processing/Tutorial.pdfにありますのでぜひご利用ください。

現在はECHONET Lite仕様書Ver.1.10、機器オブジェクト仕様Release Cに対応しています。

本ライブラリの作成には、弊社から公開されている[ECHONET Liteデータベース][]を用いています。

[ECHONET Lite]: http://www.echonet.gr.jp/ "ECHONET Lite"
[株式会社ソニーコンピュータサイエンス研究所]: http://www.sonycsl.co.jp/ "株式会社ソニーコンピュータサイエンス研究所"
[MITライセンス]: http://opensource.org/licenses/mit-license.php "MITライセンス"
[Processing]: http://processing.org "Processing"
[神奈川工科大学スマートハウス研究センター]: http://smarthouse-center.org/sdk/ "神奈川工科大学スマートハウス研究センター"
[ECHONET Liteデータベース]: https://github.com/SonyCSL/ECHONETLite-ObjectDatabase "ECHONET Liteデータベース"