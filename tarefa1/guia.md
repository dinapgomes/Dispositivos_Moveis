# Widgets no Flutter

Um widget é um objeto que descreve uma parte da interface do usuário, como um botão, uma caixa de texto, uma imagem, entre outros. Esses widgets são organizados em uma árvore hierárquica, onde o widget raiz é o MaterialApp.
Cada widget possui um conjunto de propriedades que podem ser definidas para personalizar a aparência e o comportamento do widget. Além disso, os widgets são altamente flexíveis e podem ser combinados para criar interfaces complexas e interativas.


## Alterando a cor do background e dos botões

Para alterar a cor do background e dos botões, podemos utilizar as propriedades de tema do Flutter. Para definir um tema, podemos utilizar o seguinte código:
```
MaterialApp(
  title: 'Minha aplicação',
  theme: ThemeData(
    primaryColor: Colors.blue,
    backgroundColor: Colors.white,
    elevatedButtonTheme: ElevatedButtonThemeData(
      style: ElevatedButton.styleFrom(
        primary: Colors.red,
      ),
    ),
  ),
  home: MinhaPagina(),
);
```

Neste exemplo, estamos definindo o tema da nossa aplicação com a cor primária azul, o background branco e os botões elevados com a cor vermelha. Para alterar a cor de outros tipos de botão, como o `TextButton`, podemos utilizar a propriedade `style` e definir a cor através da propriedade `foregroundColor`.

Também podemos alterar a cor de um widget individualmente, utilizando a propriedade `color` ou `backgroundColor`. Por exemplo:
```
ElevatedButton(
  onPressed: () {},
  child: Text('Meu botão'),
  style: ElevatedButton.styleFrom(
    primary: Colors.green,
  ),
),
```
