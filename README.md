# 🎮 My Dualshock 4 Controller


**Driver para comunicação com o controle DualShock 4 (PS4)**

Este projeto é uma biblioteca Java desenvolvida com o objetivo de permitir a comunicação direta com o controle do PlayStation 4 (DualShock 4), utilizando a biblioteca [hid4java](https://github.com/gary-rowe/hid4java).
Foi criado como uma iniciativa pessoal e de aprendizado, portanto, **sem garantias oficiais**.

---

## 🚀 Motivação

No passado, diversas bibliotecas permitiam a comunicação com controles de videogame em Java, mas muitas deixaram de ser mantidas. Esta biblioteca foi criada para preencher essa lacuna.

---

## 📦 Requisitos

* Java 21+
* Maven
* Controle Dualshock 4 via cabo USB (modo HID)
* [hid4java](https://github.com/gary-rowe/hid4java) (já incluída como dependência no `pom.xml`)
* Sistema operacional com suporte a dispositivos HID (Windows, Linux ou macOS)

---

## ⚙️ Como usar

### 1. Clone este repositório

```bash
git clone https://github.com/PedroMagno11/MyDualshock4Controller
cd MyDualshock4Controller
```

### 2. Instale a biblioteca localmente

```bash
mvn clean install
```

> Isso compilará e instalará a biblioteca no seu repositório Maven local (`~/.m2`).

---

### 3. Adicione a dependência ao seu projeto Maven:

```xml
<dependency>
  <groupId>br.com.pedromagno</groupId>
  <artifactId>myDualshock4Controller</artifactId>
  <version>1.0</version>
</dependency>
```

---
## 🧐 Atenção aqui

* `MyDualshockSample.java` é um exemplo simples de uso (consulte este para testes).
* `Main.java` é um exemplo simples usando a classe MyDualshockSample.

---

## 🧪 Testado em:

* Windows 10 e 11
* Java 21
* Controle DualShock 4 (via cabo USB)

---

## ⚠️ Aviso

Este projeto foi criado para fins educacionais e experimentais.
**Use por sua conta e risco.** Não há garantias de funcionamento em todos os cenários.

---

## 👨‍💻 Autor

[Pedro Magno](https://github.com/PedroMagno11)
