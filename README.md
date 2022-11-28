# try_android_stuff

## ビルド方法
[core/src/main/res/values/environments.xml](https://github.com/BigBackBoom/try_android_stuff/blob/main/core/src/main/res/values/environments.xml)の以下の値に、GithubのPersonal Access Tokenを設定する

**※パブリックなレポジトリのため、Githubにプッシュするとトークンが削除されるので、設定が必要**

```xml
<string name="github_token">xxxxxxxxxxxxxxxxxxxx</string>
```


## アーキテクチャ
- 現在は推奨から外れてしまっているが、Googleが推奨していた**MVVMのアーキテクチャ**を利用する。
<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png?hl=ja" height="360px">

## Minimum SDK
- API 26 (Android 8.0以上)
  - Android7以下の8%は今回は諦める
  - githubを使うターゲットがAndroid７以下を使っていることはあまりないと想定。

## マルチモジュールコンポーネント

![Untitled Diagram](https://user-images.githubusercontent.com/8305895/204300955-a07e4ef9-eaec-4687-8a60-e9ef38a1c2f9.png)

## ビルドツール
- gradle (ktsのみ使用)

## 利用ライブラリ

### UI
- **★従来のxmlベースのUIを利用する**
  - 時間の制約を考えて、Jetpack Composeはalpha版をある程度触った程度の経験の状態て、知識のキャッチアップとComposeに適したアーキテクチャなどの検討と模索は時間がかかるので今回は利用を見送り
- Material Components

### Android Architecture Components
- navigation
- Hilt
- ViewModel
- LiveData

### 非同期処理
- Kotlin Coroutine
- Flow

### ネットワーク
- Okhttp3
- Retrofit
- Kotlin Serializableを利用

## デザイン対応
- Material2（最新はMaterial3）
  - 知見がないのと、キャッチアップの時間を考慮して一旦Material 3対応は見送り
- ダークモード対応は行う
  - 時間的に苦しいが、デファクトであることと、  いつ対応が必須になるかわからないため対応しておく
- Font・カラーテーマはMaterial Designの公式ツールを使いながら、適度に問題ないものを選択
  - デザイナーではないので、いつでも変えれる状態であれば、 そこまでこだわる理由もない

## そのほかできれば対応
- マルチ画面対応 
  - Android 12L以上向けの、二つ同時にアプリを開いた状態にするマルチ画面対応
  - デザインがそこまで崩れなければ対応はアリかも？
- 横画面対応
  - 基本はPortrai固定で行くが、Landscapeもできれば対応した。
  - マルチ画面対応もするとなると必須
  - あまりに横画面と縦画面でレイアウトを変更し、２倍の労力がかかるなどとなれば、オミットする。

## 残対応表
https://github.com/users/BigBackBoom/projects/1
